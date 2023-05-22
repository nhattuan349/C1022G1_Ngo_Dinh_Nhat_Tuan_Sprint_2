import {Account} from './account';

export interface Orders {
  orderId?: number;
  orderCode?: string;
  orderDate?: string;
  orderFlagDelete?: boolean;
  deliveryStatus?: string;
  account?: Account;
}
