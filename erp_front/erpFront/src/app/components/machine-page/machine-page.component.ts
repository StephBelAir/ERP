import {Component, OnInit} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MachineDialogComponent} from "../machine-dialog/machine-dialog.component";
import {MachineService} from "../../services/machine.service";


@Component({
  selector: 'app-machine-page',
  templateUrl: './machine-page.component.html',
  styleUrls: ['./machine-page.component.scss']
})
export class MachinePageComponent implements OnInit {

  constructor(private dialog: MatDialog, private machineService: MachineService) {
  }

  openDialog() {
    this.dialog.open(MachineDialogComponent, {
      width: '30%'
    });
  }

  getAllMachines() {
    this.machineService.getMachine()
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (err) => {
          alert("Error while fetching the Records !!")
        }
      })
  }

  ngOnInit(): void {
    this.getAllMachines()
  }

}
