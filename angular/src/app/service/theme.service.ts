import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theme } from '../model/Theme';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  constructor(private http: HttpClient) { }

  public addTheme(theme: Theme): Observable<Theme> {
    return this.http.post<Theme>('http://localhost:8080/api/addTheme', theme);
  }

  public getThemes(): Observable<Theme[]> {
    return this.http.get<Theme[]>('http://localhost:8080/api/getThemes');
  }

  public getTheme(id: number): Observable<Theme> {
    return this.http.get<Theme>(`http://localhost:8080/api/getTheme/${id}`);
  }

  public deleteTheme(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/api/deleteTheme/${id}`);
  }
}
