import { Component } from '@angular/core';
import { NgForm } from '@angular/forms'; // Import if using template-driven forms
import { UserService } from '../user/user.service';

@Component({
 selector: 'app-forgetpassword',
 templateUrl: './forgetpassword.component.html',
 styleUrls: ['./forgetpassword.component.css']
})
export class ForgetpasswordComponent {

 constructor(private userService: UserService) { }

 onSubmit(form: NgForm) {
   const email = form.value.email;
   this.userService.forgetPassword(email).subscribe(
     response => {
      console.log('Reset link sent successfully');
     },
     error => {
      console.error('Failed to send reset link', error);
     }
   );
 }


}

