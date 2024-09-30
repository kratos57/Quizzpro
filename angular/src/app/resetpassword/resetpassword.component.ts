import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user/user.service';

@Component({
 selector: 'app-resetpassword',
 templateUrl: './resetpassword.component.html',
 styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {
 newPassword: string = '';
 confirmPassword: string = '';

 constructor(private userService: UserService, private activatedRoute: ActivatedRoute) { }

 ngOnInit(): void {
 }

 onSubmit() {
  const token = this.activatedRoute.snapshot.queryParamMap.get('token');
  if (token === null) {
    console.error('No token provided');
    return;
  }
  const newPassword = this.newPassword;
  this.userService.resetPassword(token, newPassword).subscribe(
    response => {
     console.log('Password updated successfully');
    },
    error => {
     console.error('Failed to update password', error);
    }
  );
 }
}

