import { Injectable } from '@angular/core';

const USERNAME_KEY = 'AuthUsername';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  [x: string]: any;

  constructor() { }

  public saveUsername(username: string) {
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY, username);
  }

  public getUsername(): string {
    const storedUsername = sessionStorage.getItem(USERNAME_KEY);
    return storedUsername ? storedUsername : ''; // Handle null by providing a default value
  }
}
