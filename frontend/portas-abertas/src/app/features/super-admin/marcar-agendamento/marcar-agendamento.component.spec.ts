import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarcarAgendamentoComponent } from './marcar-agendamento.component';

describe('MarcarAgendamentoComponent', () => {
  let component: MarcarAgendamentoComponent;
  let fixture: ComponentFixture<MarcarAgendamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MarcarAgendamentoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MarcarAgendamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
