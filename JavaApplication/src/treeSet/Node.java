package treeSet;

import java.util.Objects;

public class Node implements Comparable<Node>{

    private String key;
    private String label;
    private Integer order;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key.equals(node.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public int compareTo(Node o) {
        if(this.order > o.getOrder()) {
            return 1;
        }else if(this.order < o.getOrder()) {
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", label='" + label + '\'' +
                ", order=" + order +
                '}';
    }

}
