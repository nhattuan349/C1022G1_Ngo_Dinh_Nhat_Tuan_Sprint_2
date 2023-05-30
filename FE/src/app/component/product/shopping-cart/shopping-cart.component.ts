import { Component, OnInit } from '@angular/core';
import Swal from "sweetalert2";
import {ViewportScroller} from "@angular/common";
import {OrderDetailService} from "../../../service/order-detail.service";
import {TokenStorageService} from "../../../service/token-storage.service";
import {Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {OrderDetail} from "../../../model/order-detail";
import {ProductDto} from "../../../dto/product-dto";
import {FormGroup} from "@angular/forms";
import {render} from "creditcardpayments/creditCardPayments";


@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  quantity = 1;
  orderDetailList: OrderDetail [] = [];
  accountId: number;
  teamPage: any = null;
  productDtoList: ProductDto [] = [];
  totalPage: number = 0;
  size: number = 0;
  p: number = 0;
  orderDetailObject: OrderDetail = {};
  orderDetailId: number
  isRendered: boolean = false;

  formGroup: FormGroup;
  pages: number[] = [];
  totalPrice: number = 0;
  hasItems: boolean;

  constructor(private viewportScroller: ViewportScroller,
              private orderDetailService: OrderDetailService,
              private token: TokenStorageService,
              private router: Router,
              private titleService: Title) {
    this.titleService.setTitle('Giỏ hàng') }

  // Hàm để tạo danh sách các trang
  private createPageList() {
    this.pages = [];
    if (this.totalPage > 0 && this.productDtoList.length > 0) { // chỉ hiển thị phân trang nếu có nhiều hơn 1 trang và có kết quả tìm kiếm
      const start = Math.max(this.p - 2, 0);
      const end = Math.min(start + 4, this.totalPage - 1);
      for (let i = start; i <= end; i++) {
        this.pages.push(i);
      }
    } else {
      this.pages.push(0); // nếu không hiển thị phân trang thì chỉ có nút button ở trang 1
    }
  }

  // Hàm để lấy dữ liệu khi chuyển sang trang mới

  private goToPageInternal(page: number) {
    this.p = page;
    this.getAll(this.p);
    this.createPageList();
  }

  ngOnInit(): void {
    this.createPageList();
    this.getUserName();

    this.getAll(this.p);
    this.getQuantityAndTotalPrice();

    // this.decreaseAmount(this.orderDetailId);
    // this.increaseAmount(this.orderDetailId);
  }

  onHead() {
    this.viewportScroller.scrollToPosition([0, 0]);
  }

  getUserName(){
    if (this.token.getToken()){
      this.accountId = this.token.getUser().accountId;
      this.getAll(this.p);
    }else {
      this.router.navigateByUrl('/login')
    }
  }

  getAll(page: number) {
    this.orderDetailService.getAllOrderDetail(this.accountId, page).subscribe(data => {
      this.teamPage = data;
      // @ts-ignore
      this.orderDetailList = data['content'];
      // @ts-ignore
      this.totalPage = data['totalPages'];
      // @ts-ignore
      this.p = data['number'];
      // @ts-ignore
      this.size = data['size'];
      console.log("tuanmnnnnnnnnnnnnn"+ this.orderDetailList);
      this.getQuantityAndTotalPrice();




    });
    this.createPageList();
  }

  previousPage() {
    if (this.p > 0) {
      this.goToPageInternal(this.p - 1);
    }
  }

  nextPage() {
    if (this.p < this.totalPage - 1) {
      this.goToPageInternal(this.p + 1);
    }
  }

  previousPageTen() {
    if (this.p > 10) {
      this.goToPageInternal(this.p - 10);
    }
  }

  nextPageTen() {
    if (this.p < this.totalPage - 9) {
      this.goToPageInternal(this.p + 10);
    }
  }

  goToPage(page: number) {
    this.p = page;
    this.goToPageInternal(page);
    // Do something to load data for the new page
  }

  increaseQuantity() {
    this.quantity++;
  }

  decreaseQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
  }

  increaseAmount(orderDetailId: number) {
    this.orderDetailService.increaseAmount(orderDetailId).subscribe((data: any) => {
      console.log(data);
    });
    console.log('okok');
    this.ngOnInit()
  }

  decreaseAmount(orderDetailId: number) {
    this.orderDetailService.decreaseAmount(orderDetailId).subscribe((data: any) => {
      console.log(data);
    });
    console.log('okok');
    this.ngOnInit()
  }


  updateBuySuccess() {
    this.orderDetailService.updateBuySuccess(this.accountId).subscribe((data: any) => {
    });
    this.ngOnInit()
  }


  deleteOrderDetail(id: any) {
    if(id != null){
      this.orderDetailService.deleteOrderDetail(id).subscribe(data => {
        const Toast = Swal.mixin({
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 1000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
          }
        });
        if (this.orderDetailList.length === 1) {
          this.orderDetailList = [];
        }
        Toast.fire({
          icon: 'success',
          title: 'Xóa thành công'
        });
        this.getAll(this.p);
      })
    } else {
      alert("Xóa không thành công");
    }
  }

  async getQuantityAndTotalPrice() {
    this.totalPrice = 0;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.orderDetailList.length; i++) {
      this.totalPrice += this.orderDetailList[i].productPromotionalPrice * this.orderDetailList[i].amount;
      if (!this.isRendered) {
        render({
          id: '#buttonPayment',
          currency: 'USD',
          value: (this.totalPrice / 23000).toFixed(2),
          onApprove: (details) => {
            // this.buy();
            this.orderDetailService.updateBuySuccess(this.accountId).subscribe((data: any) => {
            });
            Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'Payment Success!',
              showConfirmButton: false,
              timer: 3000
            });
            console.log(this.totalPrice);
            this.router.navigateByUrl('/');
          }
        });
      }
      this.isRendered = true;
    }
  }

  // private buy() {
  //   const codeOrder = 'DAcademy-' + this.lastCode.toString().padStart(4,'0');
  //
  //   for (let i = 0; i < this.carts.length; i++) {
  //     this.orderService.order(
  //       this.carts[i].quantity * this.carts[i].price, this.carts[i].id,
  //       this.carts[i].idCourse, codeOrder).subscribe(data => {
  //       this.orderDto = data;
  //     });
  //   }
  //   this.cartService.setFlagDelete(this.user.id).subscribe();
  //   // // Lưu giá trị của biến orderCount vào localStorage
  //   // localStorage.setItem('orderCount', orderCount.toString());
  // }
}
