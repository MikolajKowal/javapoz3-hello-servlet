package com.sda.todo;

public interface TodoChainElement {

    boolean isMyResponsibility(String path);

    String action();
}