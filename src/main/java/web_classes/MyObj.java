package web_classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 123
 */
@XmlRootElement
public class MyObj 
{
    @XmlElement
    private String firstpar;
    @XmlElement
    private String secondpar;
    @XmlElement
    private int operator;
    @XmlElement
    private String result;
    public MyObj(){}
    public MyObj(String f, String s, int o)
    {
        this.firstpar = f;
        this.secondpar = s;
        this.operator = o;
    }
    public String get_f()
    {return this.firstpar;}
    public String get_s()
    {return this.secondpar;}
    public String get_res()
    {return this.result;}
    public int get_oper()
    {return this.operator;}
    @XmlTransient
    public void set_res(String res)
    {this.result = res;}
}
