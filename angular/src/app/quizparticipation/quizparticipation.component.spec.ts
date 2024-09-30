import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizparticipationComponent } from './quizparticipation.component';

describe('QuizparticipationComponent', () => {
  let component: QuizparticipationComponent;
  let fixture: ComponentFixture<QuizparticipationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuizparticipationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuizparticipationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
