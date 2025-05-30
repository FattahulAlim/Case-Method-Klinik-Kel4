package SourceCode;

public class NodeTransaksi {
    TransaksiLayanan data;
    NodeTransaksi next;

    public NodeTransaksi(TransaksiLayanan data, NodeTransaksi next){
        this.data = data;
        this.next = next;
    }

}
