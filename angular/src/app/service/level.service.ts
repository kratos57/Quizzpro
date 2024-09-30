import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Level} from "../model/Level";

@Injectable({
  providedIn: 'root'
})
export class LevelService {

  constructor(private http: HttpClient) { }

  public addLevel(level: Level, idTheme: number): Observable<Level> {
    return this.http.post<Level>(`http://localhost:8080/api/addLevel/${idTheme}`, level);
  }
  public getLevels(idTheme: number): Observable<Level[]> {
    return this.http.get<Level[]>(`http://localhost:8080/api/getLevels/${idTheme}`);
  }
  public getLevel(id: number): Observable<Level> {
    return this.http.get<Level>(`http://localhost:8080/api/getLevel/${id}`);
  }
  public deleteLevel(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/api/deleteLevel/${id}`);
  }

}
