export interface IStaff {
  id: number;
  name?: string | null;
  chucVu?: string | null;
}

export type NewStaff = Omit<IStaff, 'id'> & { id: null };
