import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthentificationComponent } from './authentification/authentification.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserAddComponent } from './user/user-add/user-add.component';
import { UserEditComponent } from './user/user-edit/user-edit.component';
import { MolistattenteComponent } from './user/molistattente/molistattente.component';
import { ListattenteComponent } from './user/listattente/listattente.component';
import { ProfilComponent } from './profil/profil.component';
import { ThemeContentComponent } from './theme-content/theme-content.component';
import { ThemeComponent } from './theme/theme.component';
import { QuizzComponent } from './quizz/quizz.component';
import { HomequizzComponent } from './homequizz/homequizz.component';
import { QuestionsComponent } from './questions/questions.component';
import { QuestionContentComponent } from './question-content/question-content.component';
import {LevelComponent} from "./level/level.component";
import { ResponsesComponent } from './responses/responses.component';
import { HistoriqueComponent } from './historique/historique.component';


import { QuizparticipationComponent } from './quizparticipation/quizparticipation.component';
import { secureInnerGuard } from './Guard/secure-inner.guard';
import { authGuard } from './Guard/auth.guard';



const routes: Routes = [

  {path:'', redirectTo:'/authentification',pathMatch:'full'},
  {path:'authentification', component:AuthentificationComponent},
  {path:'inscription', component:InscriptionComponent},
  {path:'forgotpassword',component:ForgetpasswordComponent},



  

  
  {path:'authentification', component:AuthentificationComponent , canActivate:[secureInnerGuard]},
  {path:'inscription', component:InscriptionComponent , canActivate:[secureInnerGuard]},
  {path:'forgotpassword',component:ForgetpasswordComponent , canActivate:[secureInnerGuard]},
  {path:'list',component:UserListComponent ,canActivate:[authGuard],data:{
    role:['ADMIN']
  }},
  {path:'listattente',component:ListattenteComponent ,canActivate:[authGuard],data:{
    role:['ADMIN']
  }},
  {path:'add',component:UserAddComponent ,canActivate:[authGuard],data:{
    role:['ADMIN']
  }},
  {path:'edit/:id',component:UserEditComponent ,canActivate:[authGuard],data:{
    role:['ADMIN']
  }},
 
  {path:'molistattente/:id',component:MolistattenteComponent ,canActivate:[authGuard],data:{
    role:['ADMIN']
  }},
  {path:'resetpassword', component: ResetpasswordComponent, canActivate:[secureInnerGuard]},

 
  {path:'profil', component: ProfilComponent ,canActivate:[authGuard]},
  {path: 'historique/:userUsername', component: HistoriqueComponent ,canActivate:[authGuard]},
  {path: 'theme', component: ThemeComponent ,canActivate:[authGuard],
   children: [
    {path: 'quizz/:idLevel', component: QuizzComponent },
    {path: 'themeContent/:id', component: ThemeContentComponent},
   ]
  },

  {
    path: 'questions',
    component: QuestionsComponent,canActivate:[authGuard],
   children: [
 
    {path: 'level/:id', component: LevelComponent,canActivate:[authGuard],
      children: [
        {path: 'questionContent/:id', component: QuestionContentComponent }
      ]},
     {
       path: 'responses/:id', component: ResponsesComponent ,canActivate:[authGuard]
     }

   ]
  },

  {path:'homequizz',component:HomequizzComponent ,canActivate:[authGuard]},
  {path:'quiz/:id',component:QuizparticipationComponent,canActivate:[authGuard]},
 

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
