export interface UserToken {
  sub: string;
  profiles: Array<any>;
  exp: number;
  iat: number;
}

export interface User {
  id: number;
  nome: string;
  crp: string;
  email: string;
  perfilId: number;
}
