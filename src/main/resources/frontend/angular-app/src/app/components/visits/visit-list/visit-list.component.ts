import {Component, Input, OnInit} from '@angular/core';
import {VisitService} from "../visit.service";
import {Visit} from "../visit";
import {Patient} from "../../patients/patient";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-visit-list',
  templateUrl: './visit-list.component.html',
  styleUrls: ['./visit-list.component.css']
})
export class VisitListComponent implements OnInit {

  @Input() visits: Visit[];
  constructor(private visitService: VisitService, private router: Router) {
    this.visits = [];


  }

  ngOnInit(): void {
    this.getAllVisitsWhenMainPage();

  }

  private getAllVisitsWhenMainPage() {
    if (this.router.url === '/visits') {
      this.visitService.getVisits().subscribe(
        (response: Visit[]) => {
          this.visits = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    }
  }
}
