import { IStaff, NewStaff } from './staff.model';

export const sampleWithRequiredData: IStaff = {
  id: 58821,
};

export const sampleWithPartialData: IStaff = {
  id: 55949,
  chucVu: 'blockchains repurpose Cameroon',
};

export const sampleWithFullData: IStaff = {
  id: 71328,
  name: 'navigating payment bandwidth',
  chucVu: 'niches America',
};

export const sampleWithNewData: NewStaff = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
