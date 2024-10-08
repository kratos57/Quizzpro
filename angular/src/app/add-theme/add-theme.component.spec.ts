import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddThemeComponent } from './add-theme.component';

describe('AddThemeComponent', () => {
  let component: AddThemeComponent;
  let fixture: ComponentFixture<AddThemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddThemeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddThemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
