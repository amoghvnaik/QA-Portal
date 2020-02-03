import { Component, Input, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { CohortSummaryModel } from '../../_common/models/cohort-summary.model';

import { randomColor } from 'randomcolor';

@Component({
  selector: 'app-cohort-chart',
  templateUrl: './cohort-chart.component.html',
  styleUrls: ['./cohort-chart.component.css']
})
export class CohortChartComponent implements OnInit {
  chart;

  labels: string[] = ['Wk1', 'Wk2', 'Wk3', 'Wk4', 'Wk5', 'Wk6', 'Wk7', 'Wk8', 'Wk9', 'Wk10', 'Wk11', 'Wk12'];

  chartDataSets: any[] = [];


  private _cohortsForGraph: CohortSummaryModel[];

  @Input() set cohortsForGraph(data: CohortSummaryModel[]) {
    this._cohortsForGraph = data;
    this.updateGraphData();
  }
  get cohortsForGraph(): CohortSummaryModel[] {
    return this._cohortsForGraph;
  }

  constructor() {
  }

  ngOnInit() {
    this.chart = new Chart('cohortCanvas', {
      type: 'line',
      data: {
        labels: this.labels,
        datasets: this.chartDataSets
      },
      options: {
        responsive: true,
        // maintainAspectRatio: false,
        animation: {
          duration: 0
        },
        hover: {
          animationDuration: 0
        },
        responsiveAnimationDuration: 0,
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{ 
            ticks: {
              max: 10,
              min: 0,
              stepSize: 1
            },
            display: true
          }],
        }
      }
    });
  }


  updateGraphData() {
    // Remove existing data from set
    while (this.chartDataSets.length) {
      this.chartDataSets.pop();
    }

    // Loop through cohorts, update graph data set
    if (this.cohortsForGraph) {
      this.cohortsForGraph.forEach(r => {
        this.chartDataSets.push({
          label: r.cohortName,
          data: r.averageRatings,
          fill: false,
          borderWidth: 1,
          borderColor: this.random_rgba(r.cohortName),
          lineTension: 0.2
        });
      });
    }

    // Trigger chart redraw
    if (this.chart) {
      this.chart.update();
    }
  }

  private random_rgba(seed) {
    return randomColor({ seed, hue: 'random', luminosity: 'bright' });

  }
}
