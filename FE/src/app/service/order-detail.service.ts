import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrderDetail} from "../model/order-detail";
import {ProductDto} from "../dto/product-dto";

const ORDER_DETAIL = 'http://localhost:8080/api/order-detail'

@Injectable({
  providedIn: 'root'
})
export class OrderDetailService {

  constructor(private httpClient: HttpClient) {
  }

  addShoppingCart(accountId: number, productId: number, amount:number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/order-detail/addCart'
      + `?accountId=` + accountId
      + `&productId=` + productId
      + `&amount=` + amount
    );
  }

  getAllOrderDetail(accountId: number, page: number): Observable<ProductDto[]> {
    return this.httpClient.get<ProductDto[]>(
      ORDER_DETAIL
      + `?id=` + accountId + `&page=` + page);
  }

  increaseAmount(orderDetailId: number):any {
    return this.httpClient.patch('http://localhost:8080/api/order-detail/increase-amount'+ `?id=` + orderDetailId, {});
  }

  decreaseAmount(orderDetailId: number):any {
    debugger
    return this.httpClient.patch('http://localhost:8080/api/order-detail/decrease-amount'+ `?id=` + orderDetailId, {});
  }

  updateBuySuccess(accountId: number):any {
    return this.httpClient.patch('http://localhost:8080/api/order-detail/update-buy-success'+ `?accountId=` + accountId, {});
  }


  deleteOrderDetail(id: number): Observable<any> {
    return this.httpClient.delete<OrderDetail>('http://localhost:8080/api/order-detail/delete/' + id);
  }

  getAllPurchaseHistoryOrderDetail(accountId: number, page: number): Observable<ProductDto[]> {
    return this.httpClient.get<ProductDto[]>(
      ORDER_DETAIL + `/purchase-history`
      + `?id=` + accountId + `&page=` + page);
  }

  getAllTotalAmount(accountId: number): Observable<OrderDetail[]> {
    return this.httpClient.get<OrderDetail[]>(
      ORDER_DETAIL + `/total/` + accountId);
  }
}
