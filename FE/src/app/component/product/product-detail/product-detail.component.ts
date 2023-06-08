import {Component, ElementRef, HostListener, OnInit, ViewChild} from '@angular/core';
import {Product} from "../../../model/product";
import {OrderDetail} from "../../../model/order-detail";
import {Images} from "../../../model/images";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../../service/product.service";
import {ViewportScroller} from "@angular/common";
import {ShareService} from "../../../service/share.service";
import {TokenStorageService} from "../../../service/token-storage.service";
import {Title} from "@angular/platform-browser";
import {OrderDetailService} from "../../../service/order-detail.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  @ViewChild('imgShowcase', {static: true})
  imgShowcase!: ElementRef<HTMLDivElement>;
  infoProduct: Product;
  productList: Product[] = [];
  orderDetailList: OrderDetail [] = [];

  imgId = 1;
  productImgList: Images[] = [];
  productImgListDisplay: Images[] = [];
  id: number;
  accountId : number;
  amount = 1;
  isLogin: boolean = false;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private viewportScroller: ViewportScroller,
              private orderDetailService: OrderDetailService,
              private shareService: ShareService,
              private token: TokenStorageService, private router: Router,
              private titleService: Title) {
    this.titleService.setTitle('Chi tiết sản phẩm')
    this.activatedRoute.paramMap.subscribe(data => {
      console.log(data);
      this.id = +data.get('id');
    });
    this.isLogin = this.token.isLogger();
  }

  ngOnInit(): void {
    this.viewportScroller.scrollToPosition([-2, -2]);
    this.getDetailById(this.id);
    this.slideImage();
    this.getUserName();
  }

  selectImage(id: number): void {
    this.imgId = id;
    this.slideImage();
  }



  slideImage(): void {
    const displayWidth = this.imgShowcase.nativeElement.querySelector('img')?.clientWidth;
    this.imgShowcase.nativeElement.style.transform = `translateX(${-(this.imgId - 1) * 0}px)`;
  }

  @HostListener('window:resize')
  onResize(): void {
    this.slideImage();
  }

  getDetailById(id: number) {
    this.productService.findProductById(id).subscribe(data => {
      console.log('detail', data);
      this.infoProduct = data;
      this.productService.getProductImage(id).subscribe(data => {
        console.log('list ảnh', data);
        this.productImgList = data;
        this.productImgListDisplay = data;
      });
    });
  }

  preventDefault(event: Event) {
    event.preventDefault();
  }

  onHead() {
    this.viewportScroller.scrollToPosition([0, 0]);
  }

  onCauHi(event: MouseEvent, elementId: string) {
    event.preventDefault();
    const element = document.getElementById(elementId);
    if (element) {
      element.scrollIntoView({behavior: 'smooth'});
    }
  }

  getUserName(){
    if (this.token.getToken()){
      this.accountId = this.token.getUser().accountId;
    }else {
      this.router.navigateByUrl('/login')
    }
  }

  addShoppingCart( productId: number) {
    this.orderDetailService.addShoppingCart(this.accountId, productId, this.amount).subscribe(()=>{
    });
    if (this.orderDetailList.length === 1 && this.infoProduct.productQuantity === 0) {
      this.orderDetailList = [];
      Swal.fire('Sản phẩm này tạm hết hàng');
    }
    this.router.navigate(['/product/shopping-cart']);
  }


}
