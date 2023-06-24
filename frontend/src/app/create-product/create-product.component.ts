import { Component, OnInit } from '@angular/core';
import {  Product } from '../product';
import { ProductService } from '../product.service';




@Component({
  selector: 'registerProduct',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  addproduct: Product = new Product();

  constructor(private productservice:ProductService) { }

  ngOnInit() {
  }

  addProducts(){
    this.productservice.addProduct(this.addproduct).subscribe(data => console.log(data),
    error => console.log(error));
    alert("Registration Successful")
  }

  onSubmit(){
    console.log("Inside on Submit")
    this.addProducts();
  }


}
