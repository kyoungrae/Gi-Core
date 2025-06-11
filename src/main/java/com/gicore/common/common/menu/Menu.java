package com.gicore.common.common.menu;

import com.gicore.common.common.Common;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "COMMON_MENU")
public class Menu extends Common {
    @Id
    private String menu_code;
    private String menu_name;
    private String menu_number;
    private String menu_level;
    private String top_menu_code;
    private String url;
    private String use_yn;
    private String menu_sequence;
    private String access_rights_group_id;
    // - - -
    private String use_yn_name;
    private String user_email;
    private String access_right_group;
}
