import {Component, OnInit} from '@angular/core';
import {Category} from "../../model/category";
import {CategoryServiceService} from "../../service/category-service.service";
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[] = [];
  messageResultEn: string = "";
  messageResultAr: string = "";
  constructor(private productService: ProductService,
              private activatedRoute:ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => {
        this.finalProducts();
      }
    )
  }

  finalProducts(){
    let idCategoryExist = this.activatedRoute.snapshot.paramMap.has('id');
    let keyExist = this.activatedRoute.snapshot.paramMap.has('key');
    if (idCategoryExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get('id');
      this.getProductsByCategoryId(idCategory);
    } else if (keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get('key');
      this.getProductsByKey(key)
    } else {
      this.getAllProducts();
    }
  }

  getAllProducts(){
    this.productService.getAllProduct().subscribe(
      data => {
        this.products = data;
      }
    )
  }

  getProductsByCategoryId(categoryId){
    this.productService.getProductById(categoryId).subscribe(
      data => {
        this.products = data;
      }
    )
  }


  getProductsByKey(key){

    this.productService.getProductByKey(key).subscribe(
      data => {
        // @ts-ignore
        if (data && 'status' in data && data.status === 'BAD_REQUEST') {
          debugger
          // @ts-ignore
          this.messageResultEn = data.bundleMessage.message_en;

          // @ts-ignore
          this.messageResultAr = data.bundleMessage.message_ar;
          this.products = [];
        } else {
          this.products = data;
        }

      }
    )
  }

}
