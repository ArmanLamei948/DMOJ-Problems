package com.Arman;

import java.util.ArrayList;
import java.util.Scanner;

public class Substrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) System.out.println(new SuffixTree(in.next()).distinctSubstrings());
    }
}

class Node {
    String sub = "";
    ArrayList<Integer> ch = new ArrayList<>();
}

class SuffixTree {
    private ArrayList<Node> nodes = new ArrayList<>();

    SuffixTree (String str) {
        nodes.add(new Node());
        for (int i = 0; i < str.length(); i++) addSuffix(str.substring(i));
    }

    void addSuffix (String suf) {
        int i = 0;
        int n = 0;
        while (i < suf.length()) {
            int child = 0;
            int cur;
            ArrayList<Integer> children = nodes.get(n).ch;
            while (true) {
                if (child == children.size()) {
                    cur = nodes.size();
                    Node temp = new Node();
                    temp.sub = suf.substring(i);
                    nodes.add(temp);
                    children.add(cur);
                    return;
                }
                cur = children.get(child);
                if (nodes.get(cur).sub.charAt(0) == suf.charAt(i)) break;
                child++;
            }
            int j = 0;
            String sub2 = nodes.get(cur).sub;
            while (j < sub2.length() && i + j < suf.length()) {
                if (sub2.charAt(j) != suf.charAt(i + j)) {
                    int prev = cur;
                    cur = nodes.size();
                    Node temp = new Node();
                    temp.sub = sub2.substring(0, j);
                    temp.ch.add(prev);
                    nodes.add(temp);
                    nodes.get(prev).sub = sub2.substring(j);
                    children.set(child, cur);
                    break;
                }
                j++;
            }
            i += j;
            n = cur;
        }
    }

    int distinctSubstrings () {
        int ret = 1;
        for (Node i : nodes) ret += i.sub.length();
        return ret;
    }
}
