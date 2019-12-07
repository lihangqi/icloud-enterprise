/*
 * COPYRIGHT. ShenZhen Li.Shangzhi  2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen Li.Shangzhi
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Nov 28, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.upms.vo;

import com.gitee.icloud.iot.common.vo.TreeNodeVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @FileName AuthorityMenuTree.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:26:06 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class AuthorityMenuTree extends TreeNodeVO<AuthorityMenuTree> implements Serializable{
    String text;
    List<AuthorityMenuTree> nodes = new ArrayList<AuthorityMenuTree>();
    String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public AuthorityMenuTree(String text, List<AuthorityMenuTree> nodes) {
        this.text = text;
        this.nodes = nodes;
    }

    public AuthorityMenuTree() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AuthorityMenuTree> getNodes() {
        return nodes;
    }

    public void setNodes(List<AuthorityMenuTree> nodes) {
        this.nodes = nodes;
    }

//    @Override
//    public void setChildren(List<TreeNodeVO> children) {
//        super.setChildren(children);
//        nodes = new ArrayList<AuthorityMenuTree>();
//    }
//
//    @Override
//    public void add(TreeNodeVO node) {
//        super.add(node);
//        AuthorityMenuTree n = new AuthorityMenuTree();
//        BeanUtils.copyProperties(node,n);
//        nodes.add(n);
//    }
}
