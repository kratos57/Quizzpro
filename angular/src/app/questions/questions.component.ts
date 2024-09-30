import { AddThemeComponent } from './../add-theme/add-theme.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Theme } from "../model/Theme";
import { ThemeService } from "../service/theme.service";
import { AddLevelComponent } from "../level/add-level/add-level.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  dialogRef: any;
  themes: Theme[] = [];

  constructor(private dialog: MatDialog, private themeService: ThemeService, private router: Router) {}

  ngOnInit(): void {
    this.fetchThemes();
  }

  fetchThemes() {
    this.themeService.getThemes().subscribe(themes => {
      this.themes = themes;
    });
  }

  public openRegister() {
    this.dialogRef = this.dialog.open(AddThemeComponent, {
      width: '420px'
    });
  }

  addLevel(id: number) {
    this.dialogRef = this.dialog.open(AddLevelComponent, {
      width: '420px',
      data: { id }
    });
  }

  deleteTheme(id: number) {
    if (confirm("Are you sure you want to delete this theme?")) {
      this.themeService.deleteTheme(id).subscribe(() => {
        // Refresh the themes after deletion
        this.fetchThemes();
      });
    }
  }
  returnToHomePage() {
    this.router.navigate(['/homequizz']); // Navigate to the home route
  }
}
