import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../user/user.service';

@Injectable({
  providedIn: 'root'
})
export class authGuard implements CanActivate {
constructor(private _router:Router , private _userservice:UserService ){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
   const token=this._userservice.getToken();
   
   if (!token)
    {
      console.log(token)
      this._router.navigate(['/authentification'])
      return false;

    }
    else{
      let role:string=this._userservice.getrole()!.toUpperCase();
   role=role.includes("ADMIN")?"ADMIN":this._userservice.getrole()!.toUpperCase();
      if (route.data['role' ] && route.data['role' ].indexOf(role)===-1)

      {
        
        this._router.navigate(['/homequizz'])
        return false;
      }
      else return true;
    }

    return true;
  }
};

