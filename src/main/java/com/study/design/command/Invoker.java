package com.study.design.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<ICommand> list = new ArrayList();
    /**
     * 每一个命令实际上代表了一个操作，这里我们不必知道具体具体操作是打开开关还是调高亮度
     * 这里ArrayList可以看做是一个责任链，每一个命令都将顺序执行
     */
    public void addCommand(ICommand command){
        list.add(command);
    }
    //执行命令
    public void action(){
        for (ICommand command:list) {
            command.excute();
        }
    }
}
