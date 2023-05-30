import {Component, HostListener, OnInit} from '@angular/core';
import {OrderDetail} from "../model/order-detail";
import {TokenStorageService} from "../service/token-storage.service";
import {ShareService} from "../service/share.service";
import {Router} from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  showBackground = false;

  username?: string;
  img?: string;
  name?: string;
  role?: string;
  accountId?: number
  isLoggedIn = false;
  nameUser: string;
  orderDetailList: OrderDetail[]=[];
  count = 0;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private route: Router) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
      this.nameUser = this.tokenStorageService.getUser().name;
      this.accountId = this.tokenStorageService.getUser().accountId;
      this.isLoggedIn = this.username != null;
    }else {
      this.isLoggedIn = false;
    }
    this.count = this.orderDetailList.length
  }

  ngOnInit(): void {
    this.loadHeader();

  }

  async logOut() {
    this.tokenStorageService.signOut();
    this.shareService.sendClickEvent();
    await Swal.fire({
      text: 'Đã đăng xuất',
      icon: 'success',
      confirmButtonText: 'OK',
      confirmButtonColor: '#2b80dd',
      // showConfirmButton: false,
      timer: 2500
    });
    await this.route.navigateByUrl('/');
    // location.reload();
  }



  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.showBackground = window.scrollY > 0;
  }
}
