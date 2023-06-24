import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from './update-product';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit{

  updateproduct: Product = new Product();

  constructor(private productservice:ProductService) { }

  ngOnInit() {
  }

  updateProduct(){
    this.productservice.updateProduct(this.updateproduct).subscribe(data => console.log(data),
    error => console.log(error));
    this.updateproduct = new Product();
    alert("Update Successful")
  }

  onSubmit(){
    console.log("Inside on Submit")
    this.updateProduct();
}
}
