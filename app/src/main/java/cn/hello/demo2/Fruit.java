package cn.hello.demo2;

/**
 * Created by Administrator on 2017/8/1.
 */

public class Fruit {

    private String fruitName;
    private int imgid;
    public Fruit(String fruitName,int imgid){
        this.fruitName = fruitName;
        this.imgid = imgid;
    }
    public String getFruitName(){
        return fruitName;
    }
    public int getImgid(){
        return  imgid;
    }
}
