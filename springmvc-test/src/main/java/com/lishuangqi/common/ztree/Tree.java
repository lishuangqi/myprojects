package com.lishuangqi.common.ztree;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Tree<T>{
    private StringBuffer html = new StringBuffer();  
    private List<TreeNode> treeNodes;
	private T ob; // 定义泛型成员变量

    public Tree(List<T> columns){
    	List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		try {

			for(T column:columns){
				if(column!=null){
					Class c = column.getClass();
					Method method1 = c.getMethod("getId");
					Method method2 = c.getMethod("getName");
					Method method3 = c.getMethod("getPid");
					Method method4 = c.getMethod("getUrl");
					TreeNode treeNode = new TreeNode();
					treeNode.setId((String)method1.invoke(column));
					treeNode.setName((String)method2.invoke(column));
					treeNode.setpId((String)method3.invoke(column));
					treeNode.setUrl((String)method4.invoke(column));
					treeNodes.add(treeNode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.treeNodes = treeNodes;
    }

    public TreeNode buildMyTree(TreeNode treeNode){
    	if(treeNode ==null){
    		treeNode = new TreeNode();
    		treeNode.setId("ROOT");
    		treeNode.setName("商品分类");
    		treeNode.setpId("-1");
    		treeNode.setOpen(true);
    		treeNode.setTarget("mainFrame");
    		treeNode.setUrl("javascript:void(0);");
    		return buildMyTree(treeNode);
    	}
    	List<TreeNode> treeNodeLists = new ArrayList<TreeNode>();
		for (TreeNode treeNode2 : treeNodes) {
            if (StringUtils.equals(treeNode.getId(), treeNode2.getpId())) {
				buildMyTree(treeNode2);
            	treeNodeLists.add(treeNode2);
            }
        }
		treeNode.setOpen(true);
		if(treeNodeLists !=null&& treeNodeLists.size()>0){
			treeNode.setOpen(true);
			treeNode.setIconSkin("");
		}
		if (StringUtils.equals("-1", treeNode.getId())) {
			treeNode.setOpen(true);
			treeNode.setIconSkin("");
		}
		treeNode.setChildren(treeNodeLists);
		return treeNode;

    }
	public TreeNode buildMyTree(TreeNode treeNode, String title){
		if(treeNode ==null){
			treeNode = new TreeNode();
			treeNode.setId("ROOT");
			treeNode.setName(title);
			treeNode.setpId("-1");
			treeNode.setOpen(true);
			treeNode.setTarget("mainFrame");
			treeNode.setUrl("javascript:void(0);");
			return buildMyTree(treeNode);
		}
		List<TreeNode> treeNodeLists = new ArrayList<TreeNode>();
		for (TreeNode treeNode2 : treeNodes) {
			if (StringUtils.equals(treeNode.getId(), treeNode2.getpId())) {
				buildMyTree(treeNode2);
				treeNodeLists.add(treeNode2);
			}
		}
		treeNode.setOpen(true);
		if(treeNodeLists !=null&& treeNodeLists.size()>0){
			treeNode.setOpen(true);
			treeNode.setIconSkin("");
		}
		if (StringUtils.equals("-1", treeNode.getId())) {
			treeNode.setOpen(true);
			treeNode.setIconSkin("");
		}
		treeNode.setChildren(treeNodeLists);
		return treeNode;

	}
	

    private void build(TreeNode treeNode){
        List<TreeNode> children = getChildren(treeNode);
        if (!children.isEmpty()) {
            html.append("\r\n<ul>");
            for (TreeNode child : children) {
            	String id = child.getId();
                html.append("\r\n<li id='" + id + "'>" + child.getName()+ "</li>");
                build(child);
            }
            html.append("\r\n</ul>");
        }
    }

    private List<TreeNode> getChildren(TreeNode treeNode){
        List<TreeNode> children = new ArrayList<TreeNode>();
        String id = treeNode.getId();
        for (TreeNode child : treeNodes) {
            if (id.equals(child.getpId())) {  
                children.add(child);  
            }  
        }  
        return children;  
    }

	public List<TreeNode> getParent(String id){
		List<TreeNode> parent = new ArrayList<TreeNode>();
		for (TreeNode child : treeNodes) {
			if (id.equals(child.getpId())) {
				parent.add(child);
				System.out.println(child.getName());
			}
		}
		return parent;
	}
}  
