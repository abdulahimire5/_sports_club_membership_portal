package com.example.sports_club_membership_portal.dto;

import com.example.sports_club_membership_portal.entity.MemberShip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberShipResponseDTO {

        private Integer membershipID;
        private Integer memberID;
        private String memberName;
        private Integer planID;
        private String planName;
        private LocalDate startDate;
        private LocalDate endDate;
        private String status;

        public static MemberShipResponseDTO fromEntity(MemberShip membership) {
                if (membership == null) return null;
                MemberShipResponseDTO dto = new MemberShipResponseDTO();
                dto.setMembershipID(membership.getMembershipID());
                if (membership.getMember() != null) {
                        dto.setMemberID(membership.getMember().getMemberId());
                        dto.setMemberName(membership.getMember().getFullName());
                }
                if (membership.getSubscriptionPlan() != null) {
                        dto.setPlanID(membership.getSubscriptionPlan().getPlanId());
                        dto.setPlanName(membership.getSubscriptionPlan().getPlanName());
                }
                dto.setStartDate(membership.getStartDate());
                dto.setEndDate(membership.getEndDate());
                dto.setStatus(membership.getStatus());
                return dto;
        }
}
