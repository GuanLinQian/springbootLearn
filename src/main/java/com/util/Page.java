package com.util;

import org.springframework.stereotype.Component;

/**
 * 时间:14:24
 * 作者：Maibenben
 **/
@Component

/*

这是一个分页的小插件
 */
public class Page {
private Integer page;//当前页
private Integer rows;//每页数量
private Long total;//总记录
private Integer allPages;//总页数
private Integer prePage;//上一页
private  Integer nextPage;//下一页

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", rows=" + rows +
                ", total=" + total +
                ", allPages=" + allPages +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {



        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Long getTotal() {

        return total;
    }

    public void setTotal(Long total) {
        this.allPages=(Integer.parseInt(Long.toString(total))+rows-1)/rows;
        this.total = total;
    }

    public Integer getAllPages() {

        return allPages;
    }



    public Integer getPrePage() {
        this.prePage=this.page==1?1:this.page-1;
        System.out.println("----正在切换至上一页");

        return prePage;
    }



    public Integer getNextPage() {

        System.out.println("----正在切换至下一页");
        this.nextPage=this.page==this.allPages?this.allPages:this.page+1;
        return nextPage;
    }

}
