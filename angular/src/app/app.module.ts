import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; // Import FormsModule

// Import Angular Material modules
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';


import { UserService } from './user/user.service';
import { UserListComponent } from './user/user-list/user-list.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { UserAddComponent } from './user/user-add/user-add.component';
import { UserEditComponent } from './user/user-edit/user-edit.component';
import { ListattenteComponent } from './user/listattente/listattente.component';
import { MolistattenteComponent } from './user/molistattente/molistattente.component';
import { ProfilComponent } from './profil/profil.component';



import { AddQuestionComponent } from './add-question/add-question.component';

import { HistoriqueComponent } from './historique/historique.component';


import { HeaderComponent } from './header/header.component';

import { QuizzComponent } from './quizz/quizz.component';
import { ThemeComponent } from './theme/theme.component';
import { ThemeContentComponent } from './theme-content/theme-content.component';

import { ResultComponent } from './result/result.component';
import { QuestionsComponent } from './questions/questions.component';
import { QuestionContentComponent } from './question-content/question-content.component';
import { ResponsesComponent } from './responses/responses.component';
import { AddThemeComponent } from './add-theme/add-theme.component';

import { LevelComponent } from './level/level.component';
import { AddLevelComponent } from './level/add-level/add-level.component';

import {MatExpansionModule} from "@angular/material/expansion";
import {MatIconModule} from "@angular/material/icon";
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { MatRadioModule } from '@angular/material/radio';
import { HomequizzComponent } from './homequizz/homequizz.component';


 // Adjust the import path

import { QuizparticipationComponent } from './quizparticipation/quizparticipation.component';
import { authGuard } from './Guard/auth.guard';
import { secureInnerGuard } from './Guard/secure-inner.guard';



@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    AuthentificationComponent,
    InscriptionComponent,
    ResetpasswordComponent,
    ForgetpasswordComponent,
    UserAddComponent,
    UserEditComponent,
    ListattenteComponent,
    MolistattenteComponent,
    ProfilComponent,
    AddQuestionComponent,
    HistoriqueComponent,  
    HeaderComponent,
    QuizzComponent,
    ThemeComponent,
    ThemeContentComponent,
    ResultComponent,
    QuestionsComponent,
    QuestionContentComponent,
    ResponsesComponent,
    AddThemeComponent,
    LevelComponent,
    AddLevelComponent,
    QuizparticipationComponent,
    HomequizzComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule, // Corrected import
    MatExpansionModule,
    MatIconModule,
    MatDialogModule, // Corrected import
    MatRadioModule,


  ],
  providers: [UserService ,authGuard ,secureInnerGuard],
  bootstrap: [AppComponent],
    schemas:  [CUSTOM_ELEMENTS_SCHEMA],


})
export class AppModule { }
