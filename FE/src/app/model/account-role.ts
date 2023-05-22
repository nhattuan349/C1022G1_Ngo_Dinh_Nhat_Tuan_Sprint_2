import {Role} from './role';
import {Account} from './account';

export interface AccountRole {
  accountRoleId?: number;
  account?: Account;
  role?: Role;
}
