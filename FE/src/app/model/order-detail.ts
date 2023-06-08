import {Product} from './product';
import {Orders} from './orders';

export interface OrderDetail {
  orderDerailId?: number;
  amount?: number;
  orderId?: number;
  productId?: number;
  name?: string;
  productImage?: string;
  productName?: string;
  productPromotionalPrice?: number
  flag_delete?: boolean;
  orderProductTime?: string;
  flag_buy?: boolean
  totalQuantity?: number;
  productQuantity?: number;
}
