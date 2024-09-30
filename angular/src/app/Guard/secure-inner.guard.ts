import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../user/user.service';

@Injectable({
  providedIn: 'root'
})
export class secureInnerGuard implements CanActivate {
constructor(private _router:Router , private _userservice:UserService ){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
   const token=this._userservice.getToken();
   if (token)
    {
      this._router.navigate(['/homequizz'])
      return false;
    }

    return true;
  }
};


