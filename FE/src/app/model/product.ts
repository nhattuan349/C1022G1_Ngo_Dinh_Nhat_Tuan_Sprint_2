import {ProductType} from './product-type';

export interface Product {
  productId?: number;
  productCode?: string;
  productQuantity?: number;
  productName?: string;
  productPrice?: number;
  description?: string;
  productImage?: string;
  productPromotionalPrice?: number;
  productFlagDelete?: boolean;
  productTypeId?: ProductType;
  productStatus?: string;
  productConfiguration?: string;
  productCPU?: string;
  productCartVGA?: string;
  productRAM?: string;
  productHardDrive?: string;
  productScreen?: string;
  // amount?: number;
}
