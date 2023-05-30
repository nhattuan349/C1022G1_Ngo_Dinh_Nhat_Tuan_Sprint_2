import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductDto} from "../../../dto/product-dto";
import {ProductService} from "../../../service/product.service";
import {ViewportScroller} from "@angular/common";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  teamPage: any = null;
  productDtoList: ProductDto [] = [];
  totalPage: number = 0;
  size: number = 0;
  search: string = '';
  search2: number = 0;
  search3: number = 0;
  p: number = 0;

  formGroup: FormGroup;
  pages: number[] = [];


  constructor(private productService : ProductService,
              private viewportScroller: ViewportScroller,
              private titleService: Title) {
    this.titleService.setTitle('SẢN PHẨM')
    this.formGroup = new FormGroup({
      search: new FormControl(''),
      search2: new FormControl(''),
      search3: new FormControl(''),
    }); }

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
    this.getAll(this.p);
    this.createPageList();
    this.onHead();
  }

  private getAll(page: number) {
    if (!this.search || !this.search.trim()){
      this.productService.getAllPriceProductDto(this.search2,this.search3, page).subscribe(data => {
        this.teamPage = data;
        // @ts-ignore
        this.productDtoList = data['content'];
        // @ts-ignore
        this.totalPage = data['totalPages'];
        // @ts-ignore
        this.p = data['number'];
        // @ts-ignore
        this.size = data['size'];
        console.log(this.productDtoList);
      });
    }
    this.productService.getAllProductDto(this.search.trim(), page).subscribe(data => {
      this.teamPage = data;
      // @ts-ignore
      this.productDtoList = data['content'];
      // @ts-ignore
      this.totalPage = data['totalPages'];
      // @ts-ignore
      this.p = data['number'];
      // @ts-ignore
      this.size = data['size'];
      console.log(this.productDtoList);
    });

    this.createPageList();
  }

  previousPage() {
    if (this.p > 0) {
      this.goToPageInternal(this.p - 1);
      this.onHead();
    }
  }

  nextPage() {
    if (this.p < this.totalPage - 1) {
      this.goToPageInternal(this.p + 1);
      this.onHead();
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

  // searchNameProduct() {
  //   // this.p = 0;
  //   // this.ngOnInit();
  //   // this.productDtoList = [];
  //   // this.productService.getAllProductDto(this.formGroup.value.search.trim(),
  //   //   0).subscribe(data => {
  //   //   // @ts-ignore
  //   //   this.productDtoList = data['content'];
  //   //   // @ts-ignore
  //   //   this.totalPage = data['totalPages'];
  //   //   // @ts-ignore
  //   //   this.p = data['number'];
  //   //   // @ts-ignore
  //   //   this.size = data['size'];
  //   //   console.log(data);
  //   // });
  //   this.getAll(this.p)
  //   this.createPageList();
  //   console.log('abc' + this.formGroup.value.search);
  //   console.log('abc' + this.formGroup.value.search2);
  //   console.log('abc' + this.formGroup.value.search3);
  // }

  // searchNameProduct() {
  //   if (this.search2 !== 0 || this.search3 !== 0) {
  //     this.productService.getAllPriceProductDto(this.search2, this.search3, this.p).subscribe(data => {
  //       this.teamPage = data;
  //       // @ts-ignore
  //       this.productDtoList = data['content'];
  //       // @ts-ignore
  //       this.totalPage = data['totalPages'];
  //       // @ts-ignore
  //       this.p = data['number'];
  //       // @ts-ignore
  //       this.size = data['size'];
  //       console.log(this.productDtoList);
  //       this.createPageList();
  //     });
  //   } else {
  //     this.search2 = 0; // Reset search2 to 0
  //     this.search3 = 0; // Reset search3 to 0
  //
  //     this.productService.getAllProductDto(this.search.trim(), this.p).subscribe(data => {
  //       this.teamPage = data;
  //       // @ts-ignore
  //       this.productDtoList = data['content'];
  //       // @ts-ignore
  //       this.totalPage = data['totalPages'];
  //       // @ts-ignore
  //       this.p = data['number'];
  //       // @ts-ignore
  //       this.size = data['size'];
  //       console.log(this.productDtoList);
  //       this.createPageList();
  //     });
  //   }
  // }

  // searchNameProduct() {
  //   if (this.search2 !== 0 || this.search3 !== 0) {
  //     this.productService.getAllPriceProductDto(this.search2, this.search3, this.p).subscribe(data => {
  //       this.teamPage = data;
  //       this.productDtoList = data['content'];
  //       this.totalPage = data['totalPages'];
  //       this.p = data['number'];
  //       this.size = data['size'];
  //       console.log(this.productDtoList);
  //       this.createPageList();
  //
  //       // Clear the price range inputs
  //       this.search2 = 0;
  //       this.search3 = 0;
  //       this.search = '';
  //       this.formGroup.get('search').reset();
  //       this.formGroup.get('search2').reset();
  //       this.formGroup.get('search3').reset();
  //     });
  //   } else {
  //     this.productService.getAllProductDto(this.search.trim(), this.p).subscribe(data => {
  //       this.teamPage = data;
  //       this.productDtoList = data['content'];
  //       this.totalPage = data['totalPages'];
  //       this.p = data['number'];
  //       this.size = data['size'];
  //
  //       // Clear the price range inputs
  //       this.search2 = 0;
  //       this.search3 = 0;
  //       this.search = '';
  //       this.formGroup.get('search').reset();
  //       this.formGroup.get('search2').reset();
  //       this.formGroup.get('search3').reset();
  //       console.log(this.productDtoList);
  //       this.createPageList();
  //     });
  //   }
  // }

  searchByNameProduct() {
    this.productService.getAllProductDto(this.search.trim(), this.p).subscribe(data => {
      this.teamPage = data;
            // @ts-ignore
            this.productDtoList = data['content'];
            // @ts-ignore
            this.totalPage = data['totalPages'];
            // @ts-ignore
            this.p = data['number'];
            // @ts-ignore
            this.size = data['size'];
      this.createPageList();
    });
  }

  searchByPriceRange() {
    this.productService.getAllPriceProductDto(this.search2, this.search3, this.p).subscribe(data => {
      this.teamPage = data;
      // @ts-ignore
      this.productDtoList = data['content'];
      // @ts-ignore
      this.totalPage = data['totalPages'];
      // @ts-ignore
      this.p = data['number'];
      // @ts-ignore
      this.size = data['size'];
      this.createPageList();
    });
  }

  searchNameProduct() {
    if (this.search2 !== 0 || this.search3 !== 0) {
      this.searchByPriceRange();
    } else {
      this.searchByNameProduct();
    }
  }






  goToPage(page: number) {
    this.p = page;
    this.goToPageInternal(page);
    this.onHead()
    // Do something to load data for the new page
  }

  onHead() {
    this.viewportScroller.scrollToPosition([0, 0]);
  }

}
