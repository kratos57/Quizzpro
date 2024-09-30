import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomequizzComponent } from './homequizz.component';

describe('HomequizzComponent', () => {
  let component: HomequizzComponent;
  let fixture: ComponentFixture<HomequizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomequizzComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HomequizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
