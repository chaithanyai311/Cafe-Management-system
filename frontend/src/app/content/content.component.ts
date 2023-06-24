import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  [x: string]: any;
  product:Observable<Product[]>

  constructor(private productservice: ProductService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
   this.product =  this.productservice.getProducts();
   console.log("test "+this.product)
  }

  deleteProductById(id:any)
  {
    this.productservice.deleteProduct(id).subscribe(data=>console.log(data),
    error=>console.log(error));
    //this.ngOnInit();
    window.location.reload();
  }

}