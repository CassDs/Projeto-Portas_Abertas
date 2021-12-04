import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.scss'],
})
export class InputTextComponent implements OnInit {
  @Input('control') control: FormControl;
  @Input('label') label: string;
  @Input('placeholder') placeholder: string;
  @Input('type') type: string = 'text';
  @Input() errorMessage: string;
  @Output() emitValue: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  ngOnInit(): void {}

  emit(value: string): void {
    this.emitValue.emit(value);
  }
}
