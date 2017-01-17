package model

import scala.beans.BeanInfo

case class Product(
  shipping:Float,
  articleNumber:String,
  title:String,
  descriptionShort:String,
  displayPrice:String,
  imageUrl:String,
  deepLink:String,
  productCategoryID:String,
  productCategoryName:String)

@BeanInfo
case class Employee(name:String, id:Int)
object Employee {
  def asJson(e: Employee): String ={
    s"""{"name":"${e.name}", "id":"${e.id}"}"""
  }
}