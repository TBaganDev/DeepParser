package ui.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Node extends DefaultMutableTreeNode {
    private Map<String, Node> subNodes;

    public Node(File file) {
        super(file);
        subNodes = new HashMap<>();
    }

    @Override
    public void add(MutableTreeNode newChild) {
        super.add(newChild);
        if(newChild instanceof Node) {
            Node child = (Node) newChild;
            subNodes.put(child.getFile().getPath(), child);
        }
    }


    @Override
    public void remove(MutableTreeNode newChild) {
        super.remove(newChild);
        if(newChild instanceof Node) {
            Node child = (Node) newChild;
            subNodes.remove(child.getFile().getPath());
        }
    }

    @Override
    public void removeAllChildren() {
        super.removeAllChildren();
        subNodes.clear();
    }

    @Override
    public String toString() {
        File file = getFile();
        String name = file.getName();
        if(name.equals("")) {
            return file.getAbsolutePath();
        }
        return name;
    }

    public File getFile() { return (File) userObject; }

    public void load() {
        search((Node parent) -> {
            File[] files = parent.getFile().listFiles();
            if(files != null) {
                for(File file : files) {
                    parent.add(new Node(file));
                }
            }
        }, null);
    }

    public boolean refresh() {
        AtomicBoolean flag = new AtomicBoolean(false); //Whether this was refreshed
        search((Node parent) -> {
            if(!parent.getFile().exists()) { //Deals with removed files
                parent.destroy();
                flag.set(true);
            } else {
                //Deals with new files
                File[] files = parent.getFile().listFiles();
                if(files != null) {
                    for(File file : files) {
                        if(!parent.hasSubFile(file)) {
                            //File is new
                            parent.add(new Node(file));
                            flag.set(true);
                        }
                    }
                }
            }
        }, null);
        return flag.get();
    }

    @Override
    public boolean isLeaf() {
        return subNodes.isEmpty();
    }

    public boolean hasSubFile(File file) {
        return subNodes.get(file.getPath()) != null; //O(1), which would normally be O(n)
    }

    public void destroy() {
        removeFromParent();
        removeAllChildren();
    }

    public void search(Consumer<Node> dequeue, BiConsumer<Node, Node> enqueue) {
        Queue<Node> queue = new ArrayDeque<>(); //Setup Node Queue
        queue.add(this); //Add root node to queue

        while (!queue.isEmpty()) {
            Node parent = queue.poll();


            if(dequeue != null) {
                dequeue.accept(parent);
            }

            for(Enumeration<Node> enumeration = parent.children(); enumeration.hasMoreElements();) {
                Node child = enumeration.nextElement();
                queue.add(child);
                if(enqueue != null) {
                    enqueue.accept(parent, child);
                }
            }
        }
    }
}
