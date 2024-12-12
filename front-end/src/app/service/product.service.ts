import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {map} from "rxjs/operators";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  allProductUrl = 'http://localhost:9090/product/getProducts';
  productByCategoryIdUrl = 'http://localhost:9090/product/getProductsBy/';
  productSearchUrl = 'http://localhost:9090/product/getProductsByletter/';
  constructor(private http: HttpClient) { }


  getAllProduct(): Observable<Product[]> {
    return this.http.get<Product[]>(this.allProductUrl).pipe(
      map(
        response => response
      )
    )
  }

  getProductById(categoryId): Observable<Product[]> {
    return this.http.get<Product[]>(this.productByCategoryIdUrl + categoryId).pipe(
      map(
        response => response
      )
    )
  }

  getProductByKey(key): Observable<Product[]> {
    return this.http.get<Product[]>(this.productSearchUrl + key).pipe(
      map(
        response => response
      )
    )
  }
}
