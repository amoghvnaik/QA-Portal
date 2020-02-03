export interface Endpoints {
  GET_FORM_TYPE: string;
  SEND_EVAL_RESPONSE: string;
  GET_TRAINER_EVALUATION_SUMMARY: string;
  GET_COHORT_COURSES_FOR_TRAINER :string;
  GET_TRAINEE_EVALUATION_SUMMARY: string;
  GET_EVALUATION_FORMS_FOR_TRAINEE: string;
  GET_EVALUATION_FOR_TRAINEE_AND_COURSE: string;
  GET_EVALUATION_FORM_FOR_ID: string;
  GET_EVALUATION_FORMS_FOR_COHORT_COURSE: string;
  CREATE_EVALUATION_FORM: string;
  UPDATE_EVALUATION_FORM: string;
  CREATE_FEEDBACK_FORM: string;
  UPDATE_FEEDBACK_FORM: string;
  GET_FEEDBACK_HISTORY_FOR_TRAINER: string;
  GET_FEEDBACK_FOR_COURSE: string;
  GET_FEEDBACK_FOR_ID: string;
  PORTAL_APPLICATIONS_API: string;
  GET_COHORT_BY_ID: string;
  GET_ALL_COURSES: string;
  GET_TRAINERS_AVAILABLE_FOR_COHORT: string;
  SAVE_COHORT: string;
  GET_COURSE_BY_ID: string;
  SAVE_COURSE: string;
  GET_ALL_TECHNOLOGY_CATEGORIES: string;
  GET_ALL_TECHNOLOGY_CATEGORY_BY_ID: string;
  SAVE_TECHNOLOGY_CATEGORY: string;
  CREATE_TECHNOLOGY_CATEGORY: string;
  CREATE_COHORT: string;
  GET_ALL_FORMS: string;
  GET_FORM_BY_ID: string;
  CREATE_FORM: string;
  SAVE_FORM: string;
  GET_ALL_APPLICATIONS: string;
  CREATE_APPLICATION: string;
  GET_APPLICATION_BY_ID: string;
  SAVE_APPLICATION: string;
  GET_ALL_PORTAL_PROJECTS: string;
  CREATE_PORTAL_PROJECT: string;
  GET_PORTAL_PROJECT_BY_ID: string;
  SAVE_PORTAL_PROJECT: string;
  GET_ALL_LOCATIONS: string;
  GET_LOCATION_BY_ID: string;
  SAVE_LOCATION: string;
  CREATE_LOCATION: string;
  GET_ALL_ROLES: string;
  GET_ALL_ROLE_NAMES: string;
  GET_ROLE_BY_ID: string;
  SAVE_ROLE: string;
  CREATE_ROLE: string;
  GET_AVAILABLE_TRAINEES_BY_COHORT_ID: string;
  GET_ALL_USERS: string;
  DELETE_USERS : string;
  UPDATE_USERS : string;
  CREATE_USER: string;
  UPDATE_USER: string;
  GET_COHORTS: string;
  GET_USER_BY_USERNAME:string;
  GET_CV_FOR_ID: string;
  GET_SKILLS_FOR_TRAINEE: string;
  GET_CURRENT_CV: string;
  GENERATE_CV: string;
  SAVE_CV_DATA: string;
  GET_SELF_REFLECTION_SUMMARY: string;
  GET_TRAINEE_COHORT: string;
  GET_USER_API_COHORTS: string;
  GET_USER_API_TRAINEES: string;
  GET_USER_API_TRAINEES_FOR_REVIEW: string;
  GET_SELF_REFLECTIONS_FOR_TRAINEE_API: string;
  CREATE_SELF_REFLECTION_API: string;
  GET_SELF_REFLECTION_API_BY_ID: string;
  UPDATE_SELF_REFLECTION_API: string;
  GET_SELF_REFLECTION_TRAINEE_BY_ID: string;
  SAVE_REFLECTION_FORM:string;
  GET_FORM_TYPE_QUESTIONS:string;
  SELF_REFLECTION_QUESTION_API: string;
  USER_API: string;
  USER_API_TRAINEES: string;
  USER_API_TRAINEES_FOR_REVIEW: string;
  GET_ALL_RATED_QUESTIONS_API: string;
  GET_ALL_SELF_REFLECTIONS_API: string;
  CREATE_SELF_REFLECTION_QUESTIONS_API:string;
  GET_SELF_REFLECTION_API: string;
  GET_SELF_REFLECTIONS_BY_STATUS_API: string;
  GET_TRAINEE: string;
  GET_ALL_FEEDBACK_API: string;
  CV_SEARCH: string;
  CREATE_COURSE: string;
}

export const endpoints: Endpoints = {
  SELF_REFLECTION_QUESTION_API : 'self-reflection-api/question',
  GET_ALL_SELF_REFLECTIONS_API : 'self-reflection-api/reflections',

  UPDATE_SELF_REFLECTION_API: 'self-reflection-api/reflection',
  SAVE_REFLECTION_FORM: 'self-reflection-api/reflection',
  CREATE_SELF_REFLECTION_API: 'self-reflection-api/reflection/',
  GET_SELF_REFLECTION_API : 'self-reflection-api/reflection',
  CREATE_SELF_REFLECTION_QUESTIONS_API : 'self-reflection-api/reflection-question',
  GET_ALL_RATED_QUESTIONS_API : 'self-reflection-api/reflection-question/questions',
  GET_SELF_REFLECTION_API_BY_ID: 'self-reflection-api/reflection/:id',
  GET_SELF_REFLECTIONS_FOR_TRAINEE_API: 'self-reflection-api/reflection/trainee',
  GET_SELF_REFLECTION_TRAINEE_BY_ID:'self-reflection-api/reflection/trainee/:traineeId',
  GET_SELF_REFLECTIONS_BY_STATUS_API : 'self-reflection-api/reflection/trainee/status',
  USER_API_TRAINEES_FOR_REVIEW : 'self-reflection-api/reflection/cohort/trainees/review/',
  GET_USER_API_TRAINEES_FOR_REVIEW: 'self-reflection-api/reflection/cohort/trainees/review/:cohortId',
  GET_SELF_REFLECTION_SUMMARY: '/self-reflection-api/reflection/summary',
  



  USER_API : 'cohort-api/user',
  GET_TRAINEE : 'cohort-api/user/trainee/',
  GET_TRAINEE_COHORT: '/cohort-api/user/trainee/cohort',
  GET_SKILLS_FOR_TRAINEE: 'cohort-api/user/trainee/skills',
  GET_USER_API_COHORTS: 'cohort-api/user/trainer/cohorts',
  GET_COHORTS : 'cohort-api/cohorts',
  GET_COHORT_BY_ID: 'cohort-api/cohort/:id',
  USER_API_TRAINEES :'cohort-api/cohort/trainees/',
  GET_USER_API_TRAINEES: 'cohort-api/cohort/trainees/:id',
  GET_ALL_COURSES: 'cohort-api/courses',
  GET_COURSE_BY_ID: '/cohort-api/course/:id',
  GET_TRAINERS_AVAILABLE_FOR_COHORT: 'cohort-api/manage/users/trainers',
  CREATE_COHORT: 'cohort-api/manage/cohort',
  SAVE_COHORT: 'cohort-api/manage/cohort',
  SAVE_COURSE: 'cohort-api/manage/course',
  CREATE_COURSE: 'cohort-api/manage/course',
  SAVE_LOCATION: '/cohort-api/manage/location',
  CREATE_LOCATION: '/cohort-api/manage/location',
  
  GET_AVAILABLE_TRAINEES_BY_COHORT_ID: '/cohort-api/manage/users/available-trainees/cohort/:id',
  GET_ALL_USERS : 'cohort-api/manage/users',
  UPDATE_USERS : 'cohort-api/manage/users',
  DELETE_USERS : 'cohort-api/manage/users/delete',
  CREATE_USER : 'cohort-api/manage/user',
  UPDATE_USER : 'cohort-api/manage/user',
  GET_USER_BY_USERNAME: 'cohort-api/manage/user/:username',
  SAVE_TECHNOLOGY_CATEGORY: 'cohort-api/manage/technology/category',
  CREATE_TECHNOLOGY_CATEGORY: 'cohort-api/manage/technology/category',
  GET_ALL_TECHNOLOGY_CATEGORIES: 'cohort-api/technology/categories',
  GET_ALL_TECHNOLOGY_CATEGORY_BY_ID: 'cohort-api/technology/category/:id',
  GET_ALL_LOCATIONS: '/cohort-api/locations',
  GET_LOCATION_BY_ID: '/cohort-api/location/:id',
  
  GET_ALL_FEEDBACK_API : 'course-feedback-api/question-feedback',
  
  GET_CV_FOR_ID: 'cv-api/cv/:id',
  GET_CURRENT_CV: 'cv-api/cv/trainee/current',
  GENERATE_CV : 'cv-api/cv/generated',
  SAVE_CV_DATA: 'cv-api/cv',

  GET_FORM_TYPE: 'form-api/form/:formType/categories',
  GET_ALL_FORMS: '/form-api/forms',
  GET_FORM_BY_ID: '/form-api/form/:id',
  GET_FORM_TYPE_QUESTIONS : 'form-api/form/:formType/questions',
  CREATE_FORM: '/form-api/manage/form',
  SAVE_FORM: '/form-api/manage/form',

  SEND_EVAL_RESPONSE: 'feedback-api/feedback',
  CREATE_FEEDBACK_FORM : 'feedback-api/feedback',
  UPDATE_FEEDBACK_FORM : 'feedback-api/feedback',
  GET_EVALUATION_FORM_FOR_ID : 'feedback-api/evaluation/:courseId',
  CREATE_EVALUATION_FORM : 'feedback-api/evaluation',
  UPDATE_EVALUATION_FORM : 'feedback-api/evaluation',
  GET_TRAINER_EVALUATION_SUMMARY: 'feedback-api/evaluation/course/:courseId',
  GET_COHORT_COURSES_FOR_TRAINER : '/feedback-api/evaluation/trainer',
  GET_TRAINEE_EVALUATION_SUMMARY : 'feedback-api/evaluation/trainee/summary',
  GET_EVALUATION_FORMS_FOR_TRAINEE : 'feedback-api/evaluation/trainee',
  GET_EVALUATION_FOR_TRAINEE_AND_COURSE : 'feedback-api/evaluation/trainee/course/:cohortCourseId',
  GET_EVALUATION_FORMS_FOR_COHORT_COURSE : 'feedback-api/evaluation/course/:cohortCourseId',
  GET_FEEDBACK_HISTORY_FOR_TRAINER : 'feedback-api/feedback/trainer',
  GET_FEEDBACK_FOR_COURSE : 'feedback-api/feedback/course/:courseId',
  GET_FEEDBACK_FOR_ID : 'feedback-api/feedback/:id',

  PORTAL_APPLICATIONS_API: 'portal-application-api/portal/applications',
  GET_ALL_APPLICATIONS: '/portal-application-api/manage/portal/applications',
  CREATE_APPLICATION: '/portal-application-api/manage/portal/application',
  GET_APPLICATION_BY_ID: '/portal-application-api/manage/portal/application/:id',
  SAVE_APPLICATION: '/portal-application-api/manage/portal/application',
  GET_ALL_PORTAL_PROJECTS: '/portal-application-api/portal/projects',
  CREATE_PORTAL_PROJECT: '/portal-application-api/manage/portal/project',
  GET_PORTAL_PROJECT_BY_ID: '/portal-application-api/portal/project/:id',
  SAVE_PORTAL_PROJECT: '/portal-application-api/manage/portal/project',
  GET_ALL_ROLES: '/portal-application-api/manage/roles',
  GET_ALL_ROLE_NAMES: '/portal-application-api/manage/roles/names',
  GET_ROLE_BY_ID: '/portal-application-api/role/:id',
  SAVE_ROLE: '/portal-application-api/manage/role',
  CREATE_ROLE: '/portal-application-api/manage/role',

  CV_SEARCH :'cv-api/cv/search',

};

export type EndpointRef = keyof Endpoints;
