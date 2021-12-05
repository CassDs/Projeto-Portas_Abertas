export interface LoginRequestModel {
  crp: string;
  senha: string;
}

export interface LoginResponseModel {
  token: string;
}
