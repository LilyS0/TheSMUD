import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayChoiceComponent } from './play-choice.component';

describe('PlayChoiceComponent', () => {
  let component: PlayChoiceComponent;
  let fixture: ComponentFixture<PlayChoiceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlayChoiceComponent]
    });
    fixture = TestBed.createComponent(PlayChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
