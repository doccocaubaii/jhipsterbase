package com.myapp.three.service.impl;

import com.myapp.three.domain.Staff;
import com.myapp.three.repository.StaffRepository;
import com.myapp.three.service.StaffService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Staff}.
 */
@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    private final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff save(Staff staff) {
        log.debug("Request to save Staff : {}", staff);
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Staff staff) {
        log.debug("Request to update Staff : {}", staff);
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> partialUpdate(Staff staff) {
        log.debug("Request to partially update Staff : {}", staff);

        return staffRepository
            .findById(staff.getId())
            .map(existingStaff -> {
                if (staff.getName() != null) {
                    existingStaff.setName(staff.getName());
                }
                if (staff.getChucVu() != null) {
                    existingStaff.setChucVu(staff.getChucVu());
                }

                return existingStaff;
            })
            .map(staffRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Staff> findAll() {
        log.debug("Request to get all Staff");
        return staffRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Staff> findOne(Long id) {
        log.debug("Request to get Staff : {}", id);
        return staffRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Staff : {}", id);
        staffRepository.deleteById(id);
    }
}
